package com.olakunle.myjpa.entity;


import com.olakunle.myjpa.entity.Tenant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LandLord {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String houseId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "landLord")
//    @JoinColumn(name = "tenant_id", referencedColumnName = "id") // Note: Associations marked as mappedBy must not define database mappings like @JoinTable or @JoinColumn
    private List<Tenant> tenants = new ArrayList<>();
}
