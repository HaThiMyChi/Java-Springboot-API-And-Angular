package com.project.shopapp.models;

public class OrderStatus {
    // Khi từ khóa final được sử dụng với một biến, biến đó trở thành một hằng số (constant).
    // Điều này có nghĩa là giá trị của biến không thể thay đổi sau khi nó đã được khởi tạo
    public static final String PENDING = "pending";
    public  static final String PROCESSING = "processing";
    public static final String SHIPPED = "shipped";
    public static final String DELIVERED = "delivered";
    public static final String CANCELLED = "cancelled";
}
