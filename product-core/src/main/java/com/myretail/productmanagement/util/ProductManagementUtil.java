package com.myretail.productmanagement.util;

public class ProductManagementUtil {

    public static final String PRODUCT_ID = "productId";

    public static final String PRODUCT_PRICE = "price";

    public static String getProductDetailsFetchUri(String productId) {
        return String.format("https://redsky.target.com/v2/pdp/tcin/%s?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics", productId);
    }

    public static String getPriceDetailsFetchUri(String productId) {
        return String.format("http://localhost:8080/product/%s/price", productId);
    }
}
