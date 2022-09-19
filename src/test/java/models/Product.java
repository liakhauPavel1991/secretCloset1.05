package models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tools.constants.Splitters;
import tools.exeptions.ListSizeException;
import tools.utils.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
public class Product {
    private String brand;
    private int finalPrice;
    private String finalPriceCurrency;
    private int originalPrice;
    private String originalPriceCurrency;
    private int discountPercentValue;
    private String discountPercentString;

    public void setFinalPrice(String finalPrice) {
        List<String> priceInfo = Arrays.stream(finalPrice.trim().split(Splitters.SPACE)).collect(Collectors.toList());
        if (priceInfo.size() != 2) {
            throw new ListSizeException("Price should contain price value and price currency");
        }
        this.finalPrice = Integer.parseInt(priceInfo.get(0));
        this.finalPriceCurrency = priceInfo.get(1);
    }

    public void setOriginalPrice(String originalPrice) {
        List<String> discountAmountInfo = Arrays.stream(originalPrice.trim().split(Splitters.SPACE)).collect(Collectors.toList());
        if (discountAmountInfo.size() != 2) {
            throw new ListSizeException("Discount amount should contain discount value and discount currency");
        }
        this.originalPrice = Integer.parseInt(discountAmountInfo.get(0));
        this.originalPriceCurrency = discountAmountInfo.get(1);
    }

    public void setDiscount(String discountPercent) {
        this.discountPercentString = discountPercent;
        this.discountPercentValue = StringUtils.getOnlyIntFromString(discountPercent);
    }

    public boolean hasDiscount() {
        return this.discountPercentValue != 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return finalPrice == product.finalPrice && originalPrice == product.originalPrice && discountPercentValue == product.discountPercentValue && brand.equals(product.brand) && Objects.equals(finalPriceCurrency, product.finalPriceCurrency) && Objects.equals(originalPriceCurrency, product.originalPriceCurrency) && Objects.equals(discountPercentString, product.discountPercentString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, finalPrice, finalPriceCurrency, originalPrice, originalPriceCurrency, discountPercentValue, discountPercentString);
    }

}
