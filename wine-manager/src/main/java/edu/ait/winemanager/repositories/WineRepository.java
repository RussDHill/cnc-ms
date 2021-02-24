package edu.ait.winemanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.ait.winemanager.dto.Wine;
import edu.ait.winemanager.dto.WineSummary;

import java.util.List;

public interface WineRepository extends JpaRepository<Wine, Integer>
{
    List<WineSummary> findAllWineSummariesBy();
    List<WineSummary> findAllWineSummariesByYear(int year);
}
