package co.th.goldworld.goldtracking.transfer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRecordRepository extends JpaRepository<TransferRecord, Long> {
    TransferRecord findByCode(String code);
}
