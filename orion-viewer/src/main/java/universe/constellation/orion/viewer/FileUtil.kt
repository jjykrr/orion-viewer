package universe.constellation.orion.viewer

import universe.constellation.orion.viewer.djvu.DjvuDocument
import universe.constellation.orion.viewer.document.Document
import universe.constellation.orion.viewer.document.DocumentWithCaching
import universe.constellation.orion.viewer.pdf.PdfDocument

import java.io.File

/**
 * User: mike
 * Date: 19.10.13
 * Time: 10:08
 */
object FileUtil {

    private fun isDjvuFile(filePathLowCase: String): Boolean {
        return filePathLowCase.endsWith("djvu") || filePathLowCase.endsWith("djv")
    }

    @JvmStatic
    @Throws(Exception::class)
    fun openFile(fileName: String): Document {
        return DocumentWithCaching(
                if (FileUtil.isDjvuFile(fileName.toLowerCase())) {
                    DjvuDocument(fileName)
                } else {
                    PdfDocument(fileName)
                }
        )
    }

    @JvmStatic
    @Throws(Exception::class)
    fun openFile(fileName: File): Document {
        return openFile(fileName.absolutePath)
    }

}
