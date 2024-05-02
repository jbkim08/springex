package org.zerock.springex.mapper;

import org.zerock.springex.domain.TodoVO;
import org.zerock.springex.dto.PageRequestDTO;
import sun.jvm.hotspot.debugger.Page;

import java.util.List;

public interface TodoMapper {

    String getTime();

    int getCount(PageRequestDTO requestDTO);

    void insert(TodoVO todoVO);

    List<TodoVO> selectAll();

    List<TodoVO> selectList(PageRequestDTO pageRequestDTO);

    TodoVO selectOne(Long tno);

    void delete(Long tno);

    void update(TodoVO todoVO);
}
