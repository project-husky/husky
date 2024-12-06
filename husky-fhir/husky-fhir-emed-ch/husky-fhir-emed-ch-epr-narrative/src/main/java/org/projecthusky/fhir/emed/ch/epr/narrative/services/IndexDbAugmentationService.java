package org.projecthusky.fhir.emed.ch.epr.narrative.services;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Optional;

/**
 * Adds information to a treatment using the INDEX database
 *
 * @author Ronaldo Loureiro
 */
public class IndexDbAugmentationService {

    private final String url;
    private final String username;
    private final String password;

    /**
     * Constructor
     *
     * @param url      the url of the database
     * @param username the username for the database connection
     * @param password the user's password
     */
    public IndexDbAugmentationService(final String url, final String username, final String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    /**
     * Adds information to the item using the INDEX database.
     *
     * <p>
     * public void augment(final NarrativeTreatmentItem item, final NarrativeLanguage lang) { if (item.getCodeType() ==
     * ProductCodeType.GTIN) { final var gtin = item.getProductCode();
     * <p>
     * if (item.getProductIngredients().size() == 0) { final var activeIngredients = this.getActiveIngredients(gtin);
     * item.setProductIngredients(activeIngredients); }
     * <p>
     * this.getProductName(gtin).ifPresent(item::setProductName);
     * <p>
     * this.getImage(String.format("https://index.hcisolutions.ch/files/pics/%s_PIF_F.jpg?key=gtin", gtin))
     * .ifPresent(item::setProductImageFront);
     * this.getImage(String.format("https://index.hcisolutions.ch/files/pics/%s_PIB_F.jpg?key=gtin", gtin))
     * .ifPresent(item::setProductImageBack); } }
     * <p>
     * /** Gets the database connection.
     *
     * @return the database connection.
     * @throws SQLException if a database access error occurs or the url is null
     */
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(this.url, this.username, this.password);
    }

    /**
     * Gets the active ingredients of a medicine
     *
     * @param gtin The medecine's GTIN
     * @param gtin the medicine's gtin.
     * @return The list with the active ingredient
     * <p>
     * private List<NarrativeTreatmentIngredient> getActiveIngredients(final String gtin) { final var
     * sqlSelectActiveIngredient = """ SELECT ms.name_fr, mcs.qty, mcs.qty_unit FROM med_article AS mas INNER JOIN
     * med_barcode AS mb ON mas.pharmacode = mb.pharmacode INNER JOIN med_product AS mp ON mas.product_no =
     * mp.product_no INNER JOIN med_component AS mcn ON mcn.product_no = mp.product_no INNER JOIN med_composition AS mcs
     * ON mcs.component_line_no = mcn.line_no AND mcs.product_no = mcn.product_no INNER JOIN med_substance AS ms ON
     * ms.substance_no = mcs.substance_no WHERE mb.barcode = ? AND mcs.substance_type = 'W'""";
     * <p>
     * try(final Connection conn = this.getConnection()) { final PreparedStatement ps =
     * conn.prepareStatement(sqlSelectActiveIngredient); ps.setString(1, gtin);
     * <p>
     * final ResultSet rs = ps.executeQuery(); final var activeIngredients = new
     * ArrayList<NarrativeTreatmentIngredient>(); while (rs.next()) { final String substanceName =
     * rs.getString("name_fr"); final String substanceQty = rs.getString("qty"); final String substanceUnit =
     * rs.getString("qty_unit");
     * <p>
     * final var quantity = new ChEmedQuantityWithEmedUnits() .setQuantity(new BigDecimal(substanceQty))
     * .setUnitCode(UnitCode.getEnum(substanceUnit));
     * <p>
     * activeIngredients.add(new NarrativeTreatmentIngredient(substanceName, quantity)); } return activeIngredients; }
     * catch (SQLException e) { return List.of(); } }
     * <p>
     * /** Gets the name of medicine.
     * @return the medicine's name.
     */
    private Optional<String> getProductName(final String gtin) {
        final var sqlSelectName = """
                SELECT mp.base_name_fr, mp.name_complement_fr
                FROM med_article AS ma
                    INNER JOIN med_barcode AS mb
                        ON ma.pharmacode = mb.pharmacode
                    INNER JOIN med_product AS mp
                        ON ma.product_no = mp.product_no
                WHERE mb.barcode = ?""";

        try (final var conn = this.getConnection()) {
            final var ps = conn.prepareStatement(sqlSelectName);
            ps.setString(1, gtin);

            final var rs = ps.executeQuery();
            rs.next();

            final var baseName = rs.getString("base_name_fr");
            final var complement_name = rs.getString("name_complement_fr");

            if (complement_name == null) {
                return Optional.of(baseName);
            }
            return Optional.of(String.format("%s %s", baseName, complement_name));

        } catch (SQLException e) {
            return Optional.empty();
        }
    }

    /**
     * Gets the image in base 64 if available.
     *
     * @param url The url of the image.
     * @return An optional with base 64 image or optional.empty().
     */
    private Optional<String> getImage(final String url) {
        try {
            final var inputStream = new URL(url).openStream();
            final var b64Img = Base64.getEncoder().encode(IOUtils.toByteArray(inputStream));
            inputStream.close();
            return Optional.of("data:image/png;base64," + b64Img);
        } catch (IOException e) {
            return Optional.empty();
        }
    }
}
