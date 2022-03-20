package co.th.goldworld.goldtracking.cash.summary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashSummaryRepository extends JpaRepository<CashSummary,Long> {
}
