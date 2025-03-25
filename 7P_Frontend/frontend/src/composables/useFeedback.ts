import { ref } from 'vue'
import axios from 'axios'

/**
 * Composable function for managing feedback operations
 * @returns {Object} An object containing reactive state and feedback methods
 */
export function useFeedback() {
  const message = ref('')
  const author = ref('')
  const feedbacks = ref([])

  /**
   * Fetches all feedback entries from the server
   * @async
   * @returns {Promise<void>}
   * @throws {Error} If the API request fails
   * @example
   * await fetchFeedbacks()
   */
  const fetchFeedbacks = async () => {
    try {
      const response = await axios.get('http://localhost:8080/feedback')
      feedbacks.value = response.data
    } catch (error) {
      console.error('Error fetching data:', error)
      throw error // Re-throw for error handling in components
    }
  }

  /**
   * Increments the helpful count for a specific feedback item
   * @async
   * @param {string} feedbackId - The ID of the feedback to update
   * @returns {Promise<void>}
   * @throws {Error} If the update operation fails
   * @example
   * await increaseHelpfulCount('12345')
   */
  const increaseHelpfulCount = async (feedbackId) => {
    try {
      await axios.put(`http://localhost:8080/feedback/${feedbackId}/helpful`)
      const updatedFeedback = feedbacks.value.find((f) => f.id === feedbackId)
      if (updatedFeedback) {
        updatedFeedback.helpfulCount += 1
      }
    } catch (error) {
      console.error('Error updating feedback:', error)
      throw error
    }
  }

  /**
   * Submits new feedback to the server
   * @async
   * @returns {Promise<void>}
   * @throws {Error} If submission fails or validation fails
   * @example
   * await submitFeedback()
   */
  const submitFeedback = async () => {
    if (!message.value.trim()) {
      const error = new Error('Message is required!')
      console.error(error)
      alert(error.message)
      throw error
    }

    try {
      const response = await axios.post('http://localhost:8080/feedback', {
        message: message.value,
        author: author.value,
      })
      feedbacks.value.push(response.data)
      message.value = ''
      author.value = ''
    } catch (error) {
      console.error('Error submitting feedback:', error)
      throw error
    }
  }

  return {
    message,
    author,
    feedbacks,
    fetchFeedbacks,
    increaseHelpfulCount,
    submitFeedback,
  }
}