package com.security.jss.mapper

import org.apache.ibatis.annotations.*

import com.security.jss.domain.Member

@Mapper
interface MemberMapper {
	
	@Results(id="MemberResult", value=[
		@Result(property = "id", column = "ID"),
		@Result(property = "password", column = "PASSWORD"),
		@Result(property = "role", column = "ROLE"),
	])
	@Select("""
	<script>
		SELECT
			ID, PASSWORD, ROLE
		FROM member
		WHERE ID = #{id}
	</script>
	""")
	Member getMemberUser(Member member);
}