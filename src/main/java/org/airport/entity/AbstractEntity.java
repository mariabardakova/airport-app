package org.airport.entity;

import java.util.Objects;

public abstract class AbstractEntity {
    private Long id;

    protected AbstractEntity() {
    }

    protected AbstractEntity(Long id) {
        this.id = Objects.requireNonNull(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AbstractEntity other = (AbstractEntity) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}