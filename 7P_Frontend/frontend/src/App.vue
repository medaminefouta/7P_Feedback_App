<template>
  <v-app>
    <v-main>
      <v-container class="d-flex flex-column align-center">
        <!-- Feedback Cards -->
        <h1>Feedback App</h1>
        <v-row justify="center" class="w-100" v-for="(feedback, i) in feedbacks" :key="i">
          <v-col cols="12" sm="6" md="4" lg="3">
            <v-card :color="color" variant="tonal" class="mx-auto" elevation="4" hover>
              <v-card-item>
                <div>
                  <div class="text-h6 mb-1">
                    {{ feedback.author || 'Anonym' }}
                  </div>
                  <div class="text-caption mb-2">{{ feedback.message }}</div>
                  <div class="text-caption">
                    <v-icon small>{{ likedFeedback(feedback.helpfulCount) }}</v-icon>
                    {{ feedback.helpfulCount }} helpful found
                  </div>
                </div>
              </v-card-item>

              <v-card-actions>
                <v-btn @click="increaseHelpfulCount(feedback.id)" color="primary" block>
                  Helpful
                </v-btn>
              </v-card-actions>
            </v-card>
          </v-col>
        </v-row>

        <!-- Feedback Form -->
        <v-sheet class="mt-8" width="400" elevation="2" rounded="lg">
          <v-form ref="form" @submit.prevent>
            <v-text-field
              v-model="message"
              :rules="[required]"
              label="Message"
              clearable
              class="mt-2 mx-4"
            ></v-text-field>

            <v-text-field v-model="author" label="Author" clearable class="mx-4"></v-text-field>

            <div class="d-flex flex-column mx-4">
              <!-- Button is disabled when message field is empty-->
              <v-btn
                class="mb-2"
                color="#5865f2"
                size="large"
                block
                :disabled="message === ''"
                @click="submitFeedback()"
              >
                Submit
              </v-btn>
            </div>
          </v-form>
        </v-sheet>
      </v-container>
    </v-main>
  </v-app>
</template>

<script setup>
import { onMounted, ref } from 'vue'
import { useFeedback } from './composables/useFeedback'

//Primary color theme for the application
const color = ref('indigo')

/**
 * Determines the appropriate thumb icon based on helpful count
 * @param {number} helpfulCount - The count of helpful votes
 * @returns {string} The Material Design icon name
 * @example
 * // Returns 'mdi-thumb-up' if likedFeedback(3)
 */
const likedFeedback = (helpfulCount) => {
  return helpfulCount === 0 ? 'mdi-thumb-up-outline' : 'mdi-thumb-up'
}

// Import composable functions and state
const { 
  message, 
  author, 
  feedbacks, 
  fetchFeedbacks, 
  increaseHelpfulCount, 
  submitFeedback 
} = useFeedback()

/**
 * Lifecycle hook that runs when the component is mounted
 * Fetches initial feedback data from the server
 */
onMounted(() => {
  fetchFeedbacks()
})

/**
 * Validation rule for required fields
 * @param {string} v - The input value to validate
 * @returns {string|boolean} Error message if invalid, true if valid
 * @example
 * // Returns "Field is required"
 * required('')
 */
const required = (v) => {
  return !!v || 'Field is required'
}
</script>
