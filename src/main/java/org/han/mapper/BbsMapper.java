package org.han.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.han.util.PageMaker;
import org.han.vo.BbsVO;

public interface BbsMapper {
	
	@Insert("insert into tbl_bbs (bno, title, userid, cont, contfile)"
			+ " values(seq_bbs.nextval, #{title}, #{userid}, #{cont}, #{contfile})")
	public void create(BbsVO vo);
	
	public List<BbsVO> list(PageMaker pm);
	
	@Select("select * from tbl_bbs where bno= #{bno}")
	public BbsVO read(int bno);
	
	@Delete("delete from tbl_bbs where bno = #{bno}")
	public void delete(int bno);
	
	@Update("update tbl_bbs set title= #{title}, cont= #{cont} where bno= #{bno}")
	public void update(BbsVO vo);
}
