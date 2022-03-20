package co.th.goldworld.goldtracking.cash.summary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CashSummaryRepository extends JpaRepository<CashSummary,Long> {
    @Query(value = "SELECT * FROM cash_summary ORDER BY id desc limit 1", nativeQuery = true)
    CashSummary findFirstOrderById();
}
