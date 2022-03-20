package co.th.goldworld.goldtracking.cash.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashItemsRepository extends JpaRepository<CashItems,Long> {
}
