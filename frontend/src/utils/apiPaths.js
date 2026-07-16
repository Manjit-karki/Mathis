export const Base_URL = 'http://localhost:5173/';

export const API_PATHS = {
  AUTH: {
    LOGIN: "/auth/login",
    REGISTER: "/auth/register",
    GET_PROFILE: "/auth/profile",
    UPDATE_PROFILE: "/auth/profile",
    CHANGE_PASSWORD: "/auth/change-password",
  },
  
  AI: {
    GENERATE_FLASHCARDS: '/api/ai/',
    GENERATE_QUIZ: '/api/ai/',
    GENERATE_SUMMARY: '/api/ai/',
    CHAT: '/api/ai/',
    EXPLAIN_CONCEPT: '/api/ai/explain-concept', 
    GET_CHAT_HISTORY: (documentId) => `/api/ai/chat-history/${documentId}`,
  },

  FLASHCARDS: {
    GET_ALL_FLASHCARD_SETS: '/api/flashcards',
    GET_FLASHCARDS_FOR_DOC: (documentId) => `/api/flashcards/${documentId}`,
    REVIEW_FLASHCARD: (cardId) => `/api/flashcards/${cardId}/review`,
    TOGGLE_STAR: (cardId) => `/api/flashcards/${cardId}/star`,
    DELETE_FLASHCARD_SET: (id) => `/api/flashcards/${id}`,
  },

  QUIZZES: {
    GET_QUIZZES_FOR_DOC: (documentId) => `/api/quizzes/${documentId}`,
    GET_QUIZ_BY_ID: (id) => `/api/quizzes/quiz/${id}`,
    SUBMIT_QUIZ: (id) => `/api/quizzes/${id}/submit`,
    GET_QUIZ_RESULTS: (id) => `/api/quizzes/${id}/results`,
    DELETE_QUIZ: (id) => `/api/quizzes/${id}`,
  },

  PROGRESS: {
    GET_DASHBOARD: "/api/progress/dashboard",
  },
};
