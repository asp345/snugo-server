package com.wafflestudio.snugo.dept.model

enum class Department(val value: String) {
	HUMANITIES("인문대학"),
	SOCIAL("사회과학대학"),
	SCIENCE("자연과학대학"),
	NURSING("간호대학"),
	CBA("경영대학"),
	ENG("공과대학"),
	CALS("농업생명과학대학"),
	ART("미술대학"),
	EDU("사범대학"),
	CHE("생활과학대학"),
	VET("수의과대학"),
	SNUPHARM("약학대학"),
	MUSIC("음악대학"),
	MEDICINE("의과대학"),
	CLS("자유전공학부"),
	SNUTI("첨단융합학부"),
	DEFAULT("기타");

	companion object {
		fun nameToDept(deptName: String): Department {
			for (i in entries) {
				if (i.value == deptName) {
					return i
				}
			}
			return DEFAULT
		}
	}
}
