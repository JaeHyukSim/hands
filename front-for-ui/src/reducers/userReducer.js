import { JOIN_USER } from "../actions/types"

export default function ( state = {}, action) {
  switch (action.type) {
    case JOIN_USER:
      return { ...state, loginSuccess: action.payload }
    default:
      return state;
  }
}