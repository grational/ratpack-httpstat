package it.italiaonline.rnd.ratpack.handlers
// external
import ratpack.error.ServerErrorHandler
import ratpack.handling.Context
// internal
import it.italiaonline.rnd.ratpack.exceptions.MissingParameterException
import it.italiaonline.rnd.ratpack.exceptions.NoResultException
import it.italiaonline.rnd.ratpack.exceptions.MetaException

final class CustomErrorHandler implements ServerErrorHandler  {
	@Override
	void error(Context ctx, Throwable throwable) throws Exception {
		def status, json
		 switch(throwable) {
			case MetaException:
				status = throwable.code()
				json   = throwable.json()
				break
			case Throwable:
				status = 200
				throwable.printStackTrace()
				json   = """{"status":"error","message":"${throwable.message.replaceAll('"',"'")}"}"""
				break
			default:
				throw new RuntimeException("From CustomErrorHandler",throwable)
		}
		ctx.response.status(status)
		ctx.response.send('application/json',json)
	}
}
