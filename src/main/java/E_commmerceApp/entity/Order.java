package E_commmerceApp.entity;

import java.util.List;

public record Order (int id, List<Product> products) {}