package wikigraph

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

import Articles.ArticleId


/**
  * Analyze the graph of Wikipedia Articles
  *
  * @param client the wikipedia client providing access to the data.
  */
final class Wikigraph(client: Wikipedia):

  /**
    * Retrieves the names of the articles linked in a page.
    * 
    * @param of the id of the page from which the links are retrieved
    * 
    * Hint: Use the methods that you implemented in WikiResult.
    */
  def namedLinks(of: ArticleId): WikiResult[Set[String]] =
    ???

  /**
    * Computes the distance between two pages using breadth first search.
    * 
    * @param start compute the distance from this page to `target`
    * @param target compute the distance from `start` to this page
    * @param maxDepth stop if the depth exceeds this value
    * 
    * @return the result of an asynchronous computation that might fail. If the
    *         maximal distance is exceeded during the search, the result is None.
    * 
    * Note: if a domain error occurs when fetching the pages linked from a page,
    *       fallback by ignoring the problematic page. On the other hand,
    *       any system failure just ends the algorithm by returning that
    *       system failure.
    * 
    * Hint: More information is provided in the description of the assignment
    *       Use the `enqueue` (or `enqueueAll`) and `dequeue` methods of `Queue`.
    */
  def breadthFirstSearch(start: ArticleId, target: ArticleId, maxDepth: Int): WikiResult[Option[Int]] =
    import scala.collection.immutable.Queue
    /**
      * This recursive method iterates on the graph.
      * 
      * The algorithm is detailed in the assignment description.
      * - When the queue is empty or the maxDepth is reached (in the next element of the queue),
      *   the search fails with None
      * - Otherwise, the next page is retrieved from the queue, and its linked pages are fetched from the
      *   dataset.
      *   The search succeeds if `target` is in this set of linked pages.
      *   Otherwise, it continues iterating on the queue by recursively calling `iter`.
      *   The `visited` argument of the recursive call should include the currently `visited` pages and
      *   the set of linked pages that were just fetched.
      *   The `q` argument of the recursive call should be:
      *     - a queue that contains the remaining pages whose linked pages need to be fetched (the current
      *       `q` without its first element),
      *     - and, to which the set of linked pages that were just fetched, and that have ''not'' already
      *       been visited, have been enqueued (with the correct distance).
      *
      * @param visited the pages that have already been visited (that we know are not the `target` page
      *                we are looking for), and that we must not add to the queue again to not iterate
      *                infinitely on graph cycles.
      * @param q the next pages whose linked pages need to be fetched, paired with their distance from
      *          the `start` page.
      * 
      * HINT: Have a look at the implementation of [[wikigraph.WikiResult#zip]] to see how to use
      *       [[wikigraph.WikiResult#flatMap]] to work with the content of [[wikigraph.WikiResult]].
      *       This is useful to chain successive calls to iter.
      * 
      * HINT: Do not forget, if a domain error occurs while retrieving the links from an article,
      *       to fallback by continuing iterating on the other articles of the queue without
      *       including the failed node. Refer to the documentation of [[wikigraph.WikiResult#fallbackTo]].
      */
    def iter(visited: Set[ArticleId], q: Queue[(Int, ArticleId)]): WikiResult[Option[Int]] =
      ???
    end iter
    if start == target then
      // The start node is the one we are looking for: the search succeeds with
      // a distance of 0.
      WikiResult.successful(Some(0))
    else
      // Otherwise, look into the pages linked from the `start` page, and
      // mark that page as already "visited"
      iter(Set(start), Queue(1 -> start))

  /**
    * Computes the distances between the articles whose list of titles is provided.
    *
    * For each article in the list, compute the distance to all the other articles
    * in the list.
    *
    * Do not compute the distance from an article and itself.
    * 
    * @param titles   titles of the articles
    * @param maxDepth stop the search when this value of distance is exceeded
    * 
    * @return An asynchronous result containing a list of tuples with
    *         the following elements:
    *           - the title of the article from which the distance is computed
    *           - the title of the article to which the distance is computed
    *           - the distance (as returned by `breadFirstSearch`).
    *          For instance:
    *          {{{
    *            Seq(
    *              ("article-1", "article-2", Some(1)),
    *              ("article-2", "article-1", None),
    *              ...
    *            )
    *          }}}
    *
    * Hint: You should use the methods that you implemented on `WikiResult` as well as
    *       `breadthFirstSearch`
    */
  def distanceMatrix(titles: List[String], maxDepth: Int = 50): WikiResult[Seq[(String, String, Option[Int])]] =
    ???
end Wikigraph
