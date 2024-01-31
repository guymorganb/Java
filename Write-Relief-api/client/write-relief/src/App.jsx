import { Route, createBrowserRouter, createRoutesFromElements, RouterProvider } from 'react-router-dom';
import { GoogleOAuthProvider } from '@react-oauth/google';
import {LandingPage} from './Layouts/LandingPage_Layout';

function App() {

  const router = createBrowserRouter(
      createRoutesFromElements(
          <>
            <Route path="/" index element={<LandingPage />} />
            {/* create Service and booking routed in another route called protected routes */}
            {/* <Route path="/services" element={<ProtectedRoutes element={<Services />} />} /> */}
            {/* Appointments page Route */}
            {/* <Route path="/booking" element={<ProtectedRoutes element={<Appointments />} />} /> */}

            {/* Reviews page Route */}
            {/* <Route path="/reviews" element={<ProtectedRoutes element={<Reviews />} />} /> */}

            {/* Privacy Policy Route */}
            {/* <Route path="/privacy" element={<PrivacyPolicy />} /> */}
            {/* Terms of use Route */}
            {/* <Route path="/terms" element={<TermsAndConditions />} /> */}
          </>
      )
  )

  return (
      <GoogleOAuthProvider clientId={`320440515782-44rgq2pmnk3j9in9t1f8g94jjom619vh.apps.googleusercontent.com`}>

          {/*<UserPreferenceProvider>*/}
            <RouterProvider router={router}/>
          {/*</UserPreferenceProvider>*/}


      </GoogleOAuthProvider>

  )
}
export default App

