package pe.mil.microservices.utils.service.interfaces;

public interface IUpdateDomainEntity<R, E> {

    R update(E entity);
}
