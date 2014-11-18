package org.han.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.han.vo.ReplyVO;

public interface ReplyMapper {
	
	@Select("select /*+index(tbl_reply pk_reply)*/ * from tbl_reply where bno= #{bno} and rno>0" )
	public List<ReplyVO> list(int bno);
	
	@Insert("insert into tbl_reply(rno,bno,userid,cont)"
			+ " values(seq_reply.nextval,#{bno},#{userid},#{cont})")
	public void create(ReplyVO vo);
	
	@Delete("delete TBL_REPLY where rno=#{rno}")
	public void delete(ReplyVO vo);
	
	@Update("update tbl_reply set cont= #{cont} where rno=#{rno}")
	public void update(ReplyVO vo);
}
