package models;

import javax.persistence.MappedSuperclass;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Base entity for all JPA classes
 */
@MappedSuperclass
public class BaseEntity {

	@Id
	@GeneratedValue
    protected Long id;

    public Long getId() {
        return id;
    }

}
