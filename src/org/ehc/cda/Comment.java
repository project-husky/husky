package org.ehc.cda;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehc.common.Util;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;

public class Comment {
  org.openhealthtools.mdht.uml.cda.ihe.Comment mComment;
  
  public Comment(org.openhealthtools.mdht.uml.cda.ihe.Comment comment) {
    this.mComment = comment;
  }
  
  public Comment (String text) {
    mComment = IHEFactory.eINSTANCE.createComment().init();
    this.setText(text);
  }

  private void setText(String text) {
    mComment.setText(Util.createEd(text));
  }
  
  public String getText() {
    return mComment.getText().getText();
  }
  
  public org.openhealthtools.mdht.uml.cda.ihe.Comment copyMdhtComment() {
    return EcoreUtil.copy(mComment);
  }
}
