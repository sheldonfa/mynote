package model;

/**
 * 财报
 * @author fangxin
 * @date 2017/11/5.
 */
public class Earning {

    private Integer id;
    private String  company;

    private String  text;

    public Integer getId() {
        return id;
    }

    public Earning setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public Earning setCompany(String company) {
        this.company = company;
        return this;
    }

    public String getText() {
        return text;
    }

    public Earning setText(String text) {
        this.text = text;
        return this;
    }

    @Override
    public String toString() {
        return "Earning{" +
                "id=" + id +
                ", company='" + company + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
