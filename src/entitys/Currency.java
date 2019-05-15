package entitys;

public enum Currency {
    USD("$", 1.0F), EURO("€", 1.12F);


    private String sign;
    private float inUSD;

    Currency(String sign, float inUSD) {
        this.sign = sign;
        this.inUSD = inUSD;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public float getInUSD() {
        return inUSD;
    }

    public void setInUSD(float inUSD) {
        this.inUSD = inUSD;
    }
}
