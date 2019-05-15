package it.italiaonline.rnd.response

class Meta {
	private final String uuid
	private final String path
	private final Map    qparams
	private final Map    body

	Meta(Map params) {
		this.uuid    = params.uuid    ?: { throw new IllegalArgumentException("The UUID parameter is invalid!") }()
		this.path    = params.path    ?: { throw new IllegalArgumentException("The path parameter is invalid!") }()
		this.qparams = params.qparams ?: [:]
		this.body    = params.body    ?: [:]
	}

	Map map() {
		[ meta: [
				uuid: this.uuid,
				request: [
					path: this.path,
					qparams: this.qparams,
					body: this.body
				],
				faults: []
		] ]
	}
}
