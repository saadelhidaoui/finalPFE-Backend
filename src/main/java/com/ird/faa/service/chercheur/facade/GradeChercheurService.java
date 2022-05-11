package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.Grade;
import com.ird.faa.ws.rest.provided.vo.GradeVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface GradeChercheurService extends AbstractService<Grade,Long,GradeVo>{


    /**
    * find Grade from database by reference (reference)
    * @param reference - reference of Grade
    * @return the founded Grade , If no Grade were
    *         found in database return  null.
    */
    Grade findByReference(String reference);

    /**
    * find Grade from database by id (PK) or reference (reference)
    * @param id - id of Grade
    * @param reference - reference of Grade
    * @return the founded Grade , If no Grade were
    *         found in database return  null.
    */
    Grade findByIdOrReference(Grade grade);


/**
    * delete Grade from database
    * @param id - id of Grade to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete Grade from database by reference (reference)
    *
    * @param reference - reference of Grade to be deleted
    * @return 1 if Grade deleted successfully
    */
    int deleteByReference(String reference);





}
