package pe.mil.microservices.utils.service.interfaces;

public interface ICrudAllDomainEntity<R, L, E, I>
    extends ISaveDomainEntity<E, R>,
    IUpdateDomainEntity<R, E>,
    IDeleteDomainEntity<E>,
    IGetAllDomainEntity<L>,
    IGetDomainEntityById<E, I>,
    IGetDomainEntityPage<R, E> {
}
