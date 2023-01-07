package pe.mil.microservices.utils.service.interfaces;

public interface IDeleteDomainEntity<E> {

    Boolean delete(E entity);
}
