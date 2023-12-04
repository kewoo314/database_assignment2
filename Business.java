package model.entity;

public class Business extends AbstractEntity{

    private int id;
    private String name;
    private String type;
    private String address;
    private float profit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer new_id) {
        id = new_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String new_name) {
        name = new_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String new_type) {
        type = new_type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String new_address) {
        address = new_address;
    }

    public float getProfit() {
        return profit;
    }

    public void setProfit(float new_profit) {
        profit = new_profit;
    }
}
