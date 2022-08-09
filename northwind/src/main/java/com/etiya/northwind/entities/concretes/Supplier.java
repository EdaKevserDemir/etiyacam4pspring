package com.etiya.northwind.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "suppliers")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private int supplierId;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "contact_name")
    private String contactName;
    @Column(name = "contact_title")
    private String contactTitle;

    @OneToMany(mappedBy = "supplier")
    List<Product> products;


}