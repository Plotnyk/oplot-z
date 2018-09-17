package app.model.entity.geography;

import app.model.entity.base.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "STREET")
@Entity
public class Street extends AbstractEntity {
    String name;
}
