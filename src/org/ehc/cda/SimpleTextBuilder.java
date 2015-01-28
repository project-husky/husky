package org.ehc.cda;

import ch.ehc.common.SectionsVACD;

public class SimpleTextBuilder extends TextBuilder {
  public static final String contentTagStr = "<content";
  String contentIdPrefix;
  String text;
  int currentContentId;

  public SimpleTextBuilder(SectionsVACD section, String newText) {
    this.contentIdPrefix = section.getContentIdPrefix();
    this.text = newText;
    addContent(text, contentIdPrefix, 1);
    this.currentContentId = 1;
  }

  public SimpleTextBuilder(SectionsVACD section, String newText, String oldText) {
    this.contentIdPrefix = section.getContentIdPrefix();

    //Calculate the current content ID
    int contentTagOccurences = countMatches(oldText, contentTagStr);
    currentContentId = contentTagOccurences+1;
    append(oldText);
    addContent(newText, contentIdPrefix, currentContentId);
  }

  public String toString() {
    return super.toString();
  }

  public int getNewTextContentIDNr() {
    return this.currentContentId;
  }


  public static int countMatches(final String str, final String sub) {
    if (str.equals("") || sub.equals("")) {
      return 0;
    }
    int count = 0;
    int idx = 0;
    while ((idx = str.indexOf(sub, idx)) != -1) {
      count++;
      idx += sub.length();
    }
    return count;
  }
}
