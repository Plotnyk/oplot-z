package app.model.entity.base;

import java.time.LocalDateTime;
import app.model.entity.person.User;

/**
 * Base class for all entities
 * @author Plotnyk
 */
public abstract class AbstractEntity {
    /**Unique entity identifier*/
    private int id;
    /**Timestamp of entity creation*/
    private LocalDateTime createdAt;
    /**Timestamp of entity last modification*/
    private LocalDateTime modifiedAt;
    /**Person who created specific entity*/
    private User createdBy;
    /**Last person who modified entity*/
    private User modifiedBy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public User getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(User modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime + result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        AbstractEntity other = (AbstractEntity) obj;
        if (other.id != id) {
            return false;
        }
        return true;
    }
}
