package co.th.goldworld.goldtracking.cash.inventory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashInventoryRepository extends JpaRepository<CashInventory, Long> {
}
