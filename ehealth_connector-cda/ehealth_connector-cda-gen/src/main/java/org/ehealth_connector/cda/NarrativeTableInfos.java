package org.ehealth_connector.cda;

import java.util.Arrays;
import java.util.List;

/**
 * <div class="en">Represent a table for the narrative text</div>
 */
public class NarrativeTableInfos {
    String tableTitle;
    List<String> tableColParams;

    public NarrativeTableInfos(String tableTitle, List<String> tableColParams) {
        this.tableTitle = tableTitle;
        this.tableColParams = tableColParams;
    }

    public NarrativeTableInfos(String tableTitle, String[] tableColParams) {
        this.tableTitle = tableTitle;
        this.tableColParams = Arrays.asList(tableColParams);
    }

    public String getTableTitle() {
        return tableTitle;
    }

    public void setTableTitle(String tableTitle) {
        this.tableTitle = tableTitle;
    }

    public List<String> getTableColParams() {
        return tableColParams;
    }

    public void setTableColParams(List<String> tableColParams) {
        this.tableColParams = tableColParams;
    }
}
