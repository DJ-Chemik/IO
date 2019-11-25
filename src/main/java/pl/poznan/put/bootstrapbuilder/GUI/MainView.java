package pl.poznan.put.bootstrapbuilder.GUI;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import pl.poznan.put.bootstrapbuilder.rest.BootstrapBuilderController;

@Route
public class MainView extends VerticalLayout{
    private Checkbox isHeaderCheckBox;
    private Checkbox isFooterCheckBox;
    private TextField titleTextField;
    private TextField typeTextField;
    private TextArea descriptionTextArea;
    private TextField imageTextField;
    private ListBox<String> seoVersionListBox;
    private ListBox<String> headerVersionListBox;
    private Button getButton;
    private TextArea result;
    private VerticalLayout vertical;
    private HorizontalLayout horizontal;

    public MainView() {
        isHeaderCheckBox = new Checkbox("Header");
        isFooterCheckBox = new Checkbox("Footer");
        headerVersionListBox = new ListBox<>();
        titleTextField = new TextField("Title");
        typeTextField = new TextField("Type");
        descriptionTextArea = new TextArea("Description");
        imageTextField = new TextField("Image");
        seoVersionListBox = new ListBox<>();
        result = new TextArea();
        vertical = new VerticalLayout();
        horizontal = new HorizontalLayout();

        headerVersionListBox.setEnabled(false);
        isHeaderCheckBox.addValueChangeListener(event -> {
            if(!isHeaderCheckBox.getValue())
                headerVersionListBox.setEnabled(false);
            else
                headerVersionListBox.setEnabled(true);
                headerVersionListBox.setValue("static");
        });
        result.setReadOnly(true);
        result.getStyle().set("minHeight", "500px").set("minWidth", "800px");

        headerVersionListBox.setItems("static", "fixed");

        seoVersionListBox.setItems("basic", "open graph", "twitter");
        seoVersionListBox.setValue("basic");

        getButton = new Button("GET HTML", buttonClickEvent -> {
            String seo;
            if(seoVersionListBox.getValue().equals("basic"))
                seo = null;
            else if(seoVersionListBox.getValue().equals("open graph"))
                seo = "og";
            else
                seo = "twitter";
            result.setValue(BootstrapBuilderController.getViaParams(isHeaderCheckBox.getValue(), isFooterCheckBox.getValue(),
                    titleTextField.getValue(), typeTextField.getValue(), descriptionTextArea.getValue(), imageTextField.getValue(),
                    headerVersionListBox.getValue(), seo
            ));
        });
        setHorizontalComponentAlignment(Alignment.CENTER, getButton, horizontal, result, titleTextField, typeTextField, descriptionTextArea, imageTextField, seoVersionListBox);

        vertical.add(isFooterCheckBox, isHeaderCheckBox, headerVersionListBox);
        horizontal.add(vertical, titleTextField, typeTextField, descriptionTextArea, imageTextField, seoVersionListBox);
        add(horizontal, getButton, result);

    }
}
