package Collections.domain;

import java.util.Objects;

public class Smartphone {
    private String serialNumber;

    private String brandName;

    public Smartphone(String serialNumber, String brandName) {
        this.serialNumber = serialNumber;
        this.brandName = brandName;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Smartphone that)) return false;
        return Objects.equals(serialNumber, that.serialNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNumber);
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "serialNumber='" + serialNumber + '\'' +
                ", brandName='" + brandName + '\'' +
                '}';
    }
}
