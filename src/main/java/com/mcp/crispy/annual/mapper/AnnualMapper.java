package com.mcp.crispy.annual.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mcp.crispy.annual.dto.AnnualDto;
import com.mcp.crispy.schedule.dto.ScheduleDto;

@Mapper
public interface AnnualMapper {
	int insertAnnual(AnnualDto scheduleDto);
	List<AnnualDto> getAnnList();
	AnnualDto getAnnById(String id);
	int modifyAnnual(AnnualDto scheduleDto);
}
