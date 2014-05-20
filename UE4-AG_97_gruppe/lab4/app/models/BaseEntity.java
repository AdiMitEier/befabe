package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Base entity for all JPA classes
 */
@Entity
public class BaseEntity {

	@Id
	@GeneratedValue
    protected Long id;

    public Long getId() {
        return id;
    }

}
