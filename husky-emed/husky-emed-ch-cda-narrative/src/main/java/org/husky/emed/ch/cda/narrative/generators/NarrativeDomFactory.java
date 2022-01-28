/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.husky.emed.ch.cda.narrative.generators;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.common.utils.xml.XmlFactories;
import org.husky.emed.ch.cda.narrative.enums.NarrativeLanguage;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.util.List;
import java.util.Objects;

/**
 * husky
 *
 * @author Quentin Ligier
 **/
public class NarrativeDomFactory {

    private static final String NS_HL7 = "urn:hl7-org:v3";

    /**
     * The language of the narrative to be generated.
     */
    private final NarrativeLanguage lang;

    /**
     * Whether the generated DOM is for HTML output ({@code true}) or StrucDocText ({@code false}).
     */
    private final boolean isHtml;

    /**
     * The DOM {@link Document} for which to generate elements.
     */
    private final Document document;

    /**
     * Constructor.
     *
     * @param lang   The generation language.
     * @param isHtml Whether the generated DOM is for HTML output ({@code true}) or StrucDocText ({@code false}).
     * @throws ParserConfigurationException if there's an issue creating the DOM {@link Document}.
     */
    public NarrativeDomFactory(final NarrativeLanguage lang,
                               final boolean isHtml) throws ParserConfigurationException {
        this.lang = Objects.requireNonNull(lang);
        this.isHtml = isHtml;

        this.document = XmlFactories.newSafeDocumentBuilder().newDocument();
        final var root = this.element("div", "text");
        this.document.appendChild(root);
    }

    /**
     * Gets the DOM {@link Document}.
     */
    public Document getDocument() {
        return document;
    }

    /**
     * Creates an element.
     *
     * @param name The element name.
     * @return The created element.
     */
    public Element element(final String name) {
        return this.isHtml
                ? this.document.createElement(name)
                : this.document.createElementNS(NS_HL7, name);
    }

    /**
     * Creates an element.
     *
     * @param htmlName         The element name for HTML output.
     * @param strucDocTextName The element name for StrucDocText output.
     * @return The created element.
     */
    public Element element(final String htmlName,
                           final String strucDocTextName) {
        return this.isHtml
                ? this.document.createElement(htmlName)
                : this.document.createElementNS(NS_HL7, strucDocTextName);
    }

    public Node text(final String content) {
        return this.document.createTextNode(content);
    }

    public Element div(final Object content,
                       @Nullable final String htmlClass) {
        final var div = this.element("div", "content");
        this.setNodeContent(div, content);
        if (htmlClass != null) {
            div.setAttribute("class", htmlClass);
        }
        return div;
    }

    public Element span(final Object content,
                       @Nullable final String htmlClass) {
        final var span = this.element("span", "content");
        this.setNodeContent(span, content);
        if (htmlClass != null) {
            span.setAttribute("class", htmlClass);
        }
        return span;
    }

    public Element p(@Nullable final Object content) {
        final var p = this.element("p", "paragraph");
        this.setNodeContent(p, content);
        return p;
    }

    public Element em(@Nullable final Object content) {
        final var em = this.element("em", "content");
        this.setNodeContent(em, content);
        if (!this.isHtml) {
            em.setAttribute("styleCode", "Emphasis");
        }
        return em;
    }

    public Element br() {
        return this.element("br", "br");
    }

    public Element title1(@Nullable final Object content) {
        final var title = this.element("h1", "content");
        this.setNodeContent(title, content);
        return title;
    }

    public Element title2(@Nullable final Object content) {
        final var title = this.element("h2", "content");
        this.setNodeContent(title, content);
        return title;
    }

    public Element title3(@Nullable final Object content) {
        final var title = this.element("h3", "content");
        this.setNodeContent(title, content);
        return title;
    }

    /**
     * Creates a link.
     *
     * @param url       The link URL.
     * @param content   The element content or {@code null}.
     * @param title     The title attribute or {@code null}.
     * @param htmlClass The class attribute or {@code null}. It's only set in HTML output.
     * @return The created element.
     */
    public Element link(final String url,
                        @Nullable final Object content,
                        @Nullable final String title,
                        @Nullable final String htmlClass) {
        final var link = this.element("a", "linkHref");
        link.setAttribute("href", url);
        this.setNodeContent(link, content);
        if (title != null) {
            link.setAttribute("title", title);
        }
        if (htmlClass != null && this.isHtml) {
            link.setAttribute("class", htmlClass);
        }
        return link;
    }

    public Element table() {
        return this.element("table");
    }

    public Element thead() {
        return this.element("thead");
    }

    public Element tbody() {
        return this.element("tbody");
    }

    public Element tfoot() {
        return this.element("tfoot");
    }

    public Element tr(@Nullable final Object content) {
        final var tr = this.element("tr");
        this.setNodeContent(tr, content);
        return tr;
    }

    public Element th(@Nullable final Object content,
                      @Nullable final String rowspan,
                      @Nullable final String colspan) {
        final var th = this.element("th");
        this.setNodeContent(th, content);
        if (rowspan != null) {
            th.setAttribute("rowspan", rowspan);
        }
        if (colspan != null) {
            th.setAttribute("colspan", colspan);
        }
        return th;
    }

    /**
     * Creates a cell.
     *
     * @param content   The element content or {@code null}.
     * @param htmlClass The class attribute or {@code null}. It's only set in HTML output.
     * @return The created element.
     */
    public Element td(@Nullable final Object content,
                      @Nullable final String htmlClass) {
        final var cell = this.element("td");
        this.setNodeContent(cell, content);
        if (htmlClass != null && this.isHtml) {
            cell.setAttribute("class", htmlClass);
        }
        return cell;
    }

    /**
     * @return
     * @throws TransformerException
     */
    public String render() throws TransformerException {
        final var transformer = XmlFactories.newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        transformer.setOutputProperty(OutputKeys.INDENT, "no");
        final var result = new StreamResult(new StringWriter());
        transformer.transform(new DOMSource(this.document), result);
        return result.getWriter().toString();
    }

    /**
     * Sets a node's content. The content may be a {@link String}, a {@link Node}/{@link Element} or a {@link List} of
     * {@link Node}s/{@link Element}s.
     *
     * @param node    The node.
     * @param content The content to set or {@code null}.
     */
    void setNodeContent(final Node node,
                        @Nullable final Object content) {
        if (content == null) {
            return;
        }
        if (content instanceof final String string) {
            node.appendChild(this.text(string));
        } else if (content instanceof final Node node2) {
            node.appendChild(node2);
        } else if (content instanceof final List<?> list) {
            for (final Object child : list) {
                this.setNodeContent(node, child);
            }
        }
    }
}
