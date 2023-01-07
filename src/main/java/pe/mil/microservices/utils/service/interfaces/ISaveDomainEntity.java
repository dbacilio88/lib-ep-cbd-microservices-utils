package pe.mil.microservices.utils.service.interfaces;

public interface ISaveDomainEntity<R, E> {

    R save(E entity);
}
