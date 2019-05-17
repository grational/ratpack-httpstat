// external
import static ratpack.groovy.Groovy.ratpack
import ratpack.error.ServerErrorHandler
// internal
import it.italiaonline.rnd.ratpack.handlers.CustomErrorHandler

ratpack {
	bindings {
		bindInstance ServerErrorHandler, new CustomErrorHandler()
	}
}
