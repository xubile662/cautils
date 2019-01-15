package glenn.base.viewmodule.spinner;

public class CategoryModel {

    int id;
    String title;
    String name;
    Object savedModel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title != null ? title : name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name != null ? name : title;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getSavedModel() {
        return savedModel;
    }

    public void setSavedModel(Object savedModel) {
        this.savedModel = savedModel;
    }
}
