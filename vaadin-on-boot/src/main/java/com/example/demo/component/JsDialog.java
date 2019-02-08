package com.example.demo.component;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.dependency.JavaScript;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.page.Page;

@JavaScript("jquery.js")
@JavaScript("jquery-ui.min.js")
@StyleSheet("jquery-ui.min.css")
public class JsDialog extends Div {
    public JsDialog() {
        setId("dialog");
        setTitle("Dialog");
        Paragraph content = new Paragraph("Content");

        // listen for clicks
        content.addClickListener(event -> {
            Page page = getUI().get().getPage();
            page.executeJavaScript(
                    "jQuery($0).dialog(\"close\");",
                    getElement());
        });

        add(content);
    }

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);

        if (attachEvent.isInitialAttach()) {
            Page page = attachEvent.getUI().getPage();
            page.executeJavaScript(
                    "jQuery($0).dialog({});",
                    getElement());
        }
    }
}