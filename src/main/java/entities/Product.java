package entities;

public class Product {

    private Integer id;
    private String name;
    private Float price;
    private Category category;
    private String image;

    public Product() {
        super();
    }

    public Product(Integer id, String name, Float price, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.image = null;
    }
    public Product(Integer id, String name, Float price, String image, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.image = (image == null) ? "" : image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Product other = (Product) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

}
