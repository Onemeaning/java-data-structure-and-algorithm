package fundamental.annotation;

public class Apple {

    @FruitProvider(id = 1,name = "红富士",address = "山东省廊坊市")
    private String appleProvider;

    public String getAppleProvider() {
        return appleProvider;
    }

    public void setAppleProvider(String appleProvider) {
        this.appleProvider = appleProvider;
    }


}
