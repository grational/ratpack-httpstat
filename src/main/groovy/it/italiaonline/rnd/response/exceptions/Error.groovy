package it.italiaonline.rnd.response.exceptions

enum Error {
	MISSING_TIME {
		@Override Integer getCode()    { 1 }
		@Override String  getType()    { 'ERROR' }
		@Override String  getMessage() { "The time parameter is missing in the path" }
	},
	abstract Integer getCode()
	abstract String  getType()
	abstract String  getMessage()
}
