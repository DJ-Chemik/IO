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

/**
 * GUI for easy Bootstrap building, with auto-requesting
 *
 * @author Mikołaj Szymczak
 * @version 1.0
 */
@Route("vaadin")
public class MainView extends VerticalLayout {

    // fields declarations
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

    /**
     * Main website handler, for fetching data from user, requesting and returning ready bootstrap code
     *
     */
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
            buttonClickHandle();
        });
        setHorizontalComponentAlignment(Alignment.CENTER, getButton, horizontal, result, titleTextField, typeTextField, descriptionTextArea, imageTextField, seoVersionListBox);

        vertical.add(isFooterCheckBox, isHeaderCheckBox, headerVersionListBox);
        horizontal.add(vertical, titleTextField, typeTextField, descriptionTextArea, imageTextField, seoVersionListBox);
        add(horizontal, getButton, result);
    }

    public void buttonClickHandle() {
        BootstrapBuilderController controller = new BootstrapBuilderController();
        String seo;
        if(seoVersionListBox.getValue().equals("basic"))
            seo = "basic";
        else if(seoVersionListBox.getValue().equals("open graph"))
            seo = "og";
        else
            seo = "twitter";
        result.setValue(controller.getViaParams(isHeaderCheckBox.getValue(), isFooterCheckBox.getValue(),
                titleTextField.getValue(), typeTextField.getValue(), descriptionTextArea.getValue(), imageTextField.getValue(),
                headerVersionListBox.getValue(), seo
        ));
    }

    public Checkbox getIsHeaderCheckBox() {
        return isHeaderCheckBox;
    }

    public void setIsHeaderCheckBox(Checkbox isHeaderCheckBox) {
        this.isHeaderCheckBox = isHeaderCheckBox;
    }

    public Checkbox getIsFooterCheckBox() {
        return isFooterCheckBox;
    }

    public void setIsFooterCheckBox(Checkbox isFooterCheckBox) {
        this.isFooterCheckBox = isFooterCheckBox;
    }

    public TextField getTitleTextField() {
        return titleTextField;
    }

    public void setTitleTextField(TextField titleTextField) {
        this.titleTextField = titleTextField;
    }

    public TextField getTypeTextField() {
        return typeTextField;
    }

    public void setTypeTextField(TextField typeTextField) {
        this.typeTextField = typeTextField;
    }

    public TextArea getDescriptionTextArea() {
        return descriptionTextArea;
    }

    public void setDescriptionTextArea(TextArea descriptionTextArea) {
        this.descriptionTextArea = descriptionTextArea;
    }

    public TextField getImageTextField() {
        return imageTextField;
    }

    public void setImageTextField(TextField imageTextField) {
        this.imageTextField = imageTextField;
    }

    public ListBox<String> getSeoVersionListBox() {
        return seoVersionListBox;
    }

    public void setSeoVersionListBox(ListBox<String> seoVersionListBox) {
        this.seoVersionListBox = seoVersionListBox;
    }

    public ListBox<String> getHeaderVersionListBox() {
        return headerVersionListBox;
    }

    public void setHeaderVersionListBox(ListBox<String> headerVersionListBox) {
        this.headerVersionListBox = headerVersionListBox;
    }

    public Button getGetButton() {
        return getButton;
    }

    public void setGetButton(Button getButton) {
        this.getButton = getButton;
    }

    public TextArea getResult() {
        return result;
    }

    public void setResult(TextArea result) {
        this.result = result;
    }
}
