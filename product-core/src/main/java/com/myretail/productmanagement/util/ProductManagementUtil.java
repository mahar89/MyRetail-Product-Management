package com.myretail.productmanagement.util;

public class ProductManagementUtil {

  public static String getProductExternalUri(String productId) {
    return String.format("https://redsky.target.com/v2/pdp/tcin/%s?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics", productId);
  }
}
